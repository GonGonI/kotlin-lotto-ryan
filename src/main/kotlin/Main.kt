package org.example

fun parseExpression(expression: String): Array<String> {
    return expression.split(" ").toTypedArray()
}

fun applyOperator(result: Int, operator: String, num: Int): Int {
    return when (operator) {
        "+" -> result + num
        "-" -> result - num
        "*" -> result * num
        "/" -> result / num
        else -> throw IllegalArgumentException("Unknown operator: $operator")
    }
}

fun calculateFromParts(stringArray: Array<String>): Int {
    var result = stringArray[0].toInt()
    var index = 1
    while (index < stringArray.size) {
        val operator = stringArray.getOrNull(index)
        val num = stringArray.getOrNull(index + 1)!!.toInt()
        result = applyOperator(result, operator.toString(), num)
        index += 2
    }
    return result
}

fun main() {
    val expression1 = "2 + 4 - 6"
    val parts1 = parseExpression(expression1)
    println(calculateFromParts(parts1)) //Output: 0

    val expression2 = "3 * 4 / 2 + 5 - 1"
    val parts2 = parseExpression(expression2)
    println(calculateFromParts(parts2)) //Output: 10

    val expression3 = "10 / 2 * 3"
    val parts3 = parseExpression(expression3)
    println(calculateFromParts(parts3)) //Output 15
}