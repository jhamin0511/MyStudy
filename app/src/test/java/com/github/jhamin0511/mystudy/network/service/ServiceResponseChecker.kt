package com.github.jhamin0511.mystudy.network.service

import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible

/**
 * Network Response 데이터가 Kotlin Data Class로 변환 될 떄 Immutable Field에 Null이 포함 되어있는지 확인
 */
@Suppress("NestedBlockDepth")
object ServiceResponseChecker {
    fun checkData(actual: Any) {
        if (actual::class.isData) {
            checkField(actual)
        } else {
            throw IllegalArgumentException("${actual::class.simpleName} is not data class.")
        }
    }

    private fun checkField(actual: Any) {
        actual::class.declaredMemberProperties.forEach { field ->
            field.isAccessible = true
            val name = field.name
            val type = field.returnType
            val value = field.getter.call(actual)

            if (value is List<*>) {
                value.forEach { element ->
                    if (element is Any) {
                        checkData(element)
                    }
                }
            }
            if (!type.isMarkedNullable) {
                if (value == null) {
                    val message = "$name is immutable field($type), but value is null."
                    throw NullPointerException(message)
                }
            }
        }
    }
}
