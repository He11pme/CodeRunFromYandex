package task31

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// Скорость не превышает 0,15 сек, память - 20.5 МБ.
fun main(args: Array<String> ) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val size = reader.readLine().toInt()
    val used = BooleanArray(size * size + 1)
    val matrix = Array(size) {IntArray(size)}

    repeat(size) { i ->
        val parts = reader.readLine().split(' ')
        for (j in 0 until size) {
            val number = parts[j].toInt()
            matrix[i][j] = number
            if (number != 0) used[number] = true
        }
    }

    var nextFree = 1
    val sb = StringBuilder()
    for (i in 0 until size) {
        sb.setLength(0)
        for (j in 0 until size) {
            if (matrix[i][j] == 0) {
                while (used[nextFree]) nextFree++
                matrix[i][j] = nextFree
                used[nextFree] = true
            }
            sb.append(matrix[i][j]).append(' ')
        }
        sb.setLength(sb.length - 1)
        writer.write(sb.toString())
        writer.newLine()
    }

    reader.close()
    writer.close()
}
