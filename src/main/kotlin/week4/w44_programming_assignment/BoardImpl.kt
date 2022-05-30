package week4.w44_programming_assignment

import week4.w44_programming_assignment.Direction.*

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(createSquareBoard(width))


open class SquareBoardImpl(override val width: Int) : SquareBoard {
    private val listOfList = arrayListOf<List<Cell>>()

    init {
        for (row in 1..width) {
            val list = arrayListOf<Cell>()
            for (column in 1..width) {
                list.add(Cell(row, column))
            }
            listOfList.add(list)
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        val x = Cell(i, j)
        listOfList.forEach { list ->
            list.forEach { cell ->
                if (cell == x) return cell
            }
        }
        return null
    }

    override fun getCell(i: Int, j: Int): Cell {
        val x = Cell(i, j)
        listOfList.forEach { list ->
            list.forEach { cell ->
                if (cell == x) return cell
            }
        }
        throw IllegalArgumentException()
    }

    override fun getAllCells(): Collection<Cell> {
        return listOfList.flatten()
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val result = mutableListOf<Cell>()
        for (cell in jRange)
            try {
                result.add(listOfList[i - 1][cell - 1])
            } catch (e: IndexOutOfBoundsException) {
                return result
            }
        return result
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val result = mutableListOf<Cell>()
        for (cell in iRange) {
            try {
                result.add(listOfList[cell - 1][j - 1])
            } catch (e: IndexOutOfBoundsException) {
                return result
            }
        }
        return result
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        return when (direction) {
            UP -> getCellOrNull(this.i - 1, this.j)
            DOWN -> getCellOrNull(this.i + 1, this.j)
            LEFT -> getCellOrNull(this.i, this.j - 1)
            RIGHT -> getCellOrNull(this.i, this.j + 1)
        }
    }
}


operator fun <T> GameBoard<T>.get(i: Int, j: Int) = get(getCell(i, j))
operator fun <T> GameBoard<T>.set(i: Int, j: Int, value: T) = set(getCell(i, j), value)


class GameBoardImpl<T>(private val squareBoard: SquareBoard) : SquareBoard by squareBoard, GameBoard<T> {
    val map = mutableMapOf<Cell, T?>()

    init {
        squareBoard.getAllCells().forEach { cell ->
            map[cell] = null
        }
    }

    override fun get(cell: Cell): T? {
        return map[cell]
    }

    override fun set(cell: Cell, value: T?) {
        map.set(cell, value)
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        return map.all { predicate(it.value) }
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        return map.any { predicate(it.value) }
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        return filter(predicate).first()
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        return map.filter { predicate(it.value) }.keys
    }
}
