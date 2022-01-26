package com.example.task.utils

import com.example.task.presentation.utils.convertLongToStrDate
import com.example.task.presentation.utils.diffDaysBetweenTwoTimes
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UtilsTest {

    /**
     * Pattern: yyyy-MM-dd HH:mm:ss
     */
    @Test
    fun `convert long time to str format time`() {
        val result = 1643115708133.convertLongToStrDate()
        Assert.assertEquals("2022-01-25 15:01:48", result)
    }

    @Test
    fun `valid start time and end time return valid num`() {
        val result = diffDaysBetweenTwoTimes(startTime = 1643548027604, endTime = 1643115708133)
        Assert.assertEquals(5, result)
    }

    @Test
    fun `swap start time and end time return negative diff num`() {
        val result = diffDaysBetweenTwoTimes(startTime = 1643115708133, endTime = 1643548027604)
        Assert.assertEquals(-5, result)
    }

}