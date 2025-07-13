package task31

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// Скорость не превышает 0,17 сек, память - 22 МБ.
fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val size = reader.readLine().toInt()
    val luckyNumber = mutableSetOf<Int>()

    val matrix = Array(size) {
        reader.readLine().split(" ").map {
            it.toInt().let { number ->
                if (number != 0) luckyNumber.add(number)
                number
            }
        }
    }

    var number = 0
    matrix.forEach { line ->
        val strLine = StringBuilder()
        line.forEach {
            if (it == 0) {
                do {
                    number++
                } while (luckyNumber.contains(number))
                strLine.append(number)
            } else strLine.append(it)
            strLine.append(' ')
        }
        strLine.setLength(strLine.length - 1)
        writer.write(strLine.toString())
        writer.newLine()
    }

    reader.close()
    writer.close()
}
