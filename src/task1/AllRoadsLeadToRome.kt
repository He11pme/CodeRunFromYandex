package task1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// Скорость 0,843 с; Память 73,92 МБ
// Создание лямбды-функции ухудшило скорость до 0,932 с.
fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val readPairNumber = {
        reader.readLine().split(' ').map { it.toInt() }
    }

    val (countTown, countRoad) = readPairNumber()

    //Проверка на возможность! наличия Рима.
    if (countTown - 1 > countRoad) {
        writer.write("-1")
        writer.close()
        return
    }

    val potentialRome = (1..countTown).associateWith { mutableSetOf<Int>() }.toMutableMap()

    repeat(countRoad) {
        val (from, to) = readPairNumber()

        if (from != to) {
            potentialRome.remove(from)
            if (potentialRome.contains(to)) potentialRome[to]?.add(from)
        }
    }

    val rome = potentialRome.entries.find { it.value.size == countTown - 1 }?.key ?: -1
    writer.write("$rome")

    reader.close()
    writer.close()
}