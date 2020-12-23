package com.frame.basic_library.data.`fun`

import java.util.regex.Pattern

object RegularFun {

    //密码规则正则
    fun checkPassword(password: String): Boolean {
        // 数字与字母 8-20
        // Pattern Password_Pattern = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$");
        //数字与字母 区分大小写 8-20
        val pwdPattern = Pattern.compile("^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{8,20}$")
        val matcher = pwdPattern.matcher(password)
        return matcher.matches()
    }

    //手机号正则
    fun isMobileNum(mobile: String): Boolean {
        val phonePattern =
            Pattern.compile("^1(3([0-35-9]\\d|4[1-8])|4[14-9]\\d|5([0125689]\\d|7[1-79])|66\\d|7[2-35-8]\\d|8\\d{2}|9[13589]\\d)\\d{7}$")
        val matcher = phonePattern.matcher(mobile)
        return matcher.matches()
    }


    //身份证正则
    fun isIdCardNum(idNumber: String): Boolean {
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        val idNumberPattern = Pattern.compile(
            "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                    "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)"
        )
        val matcher = idNumberPattern.matcher(idNumber)
        val matches = matcher.matches()
        //假设18位身份证号码:41000119910101123X  410001 19910101 123X
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
        //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
        //$结尾

        //假设15位身份证号码:410001910101123  410001 910101 123
        //^开头
        //[1-9] 第一位1-9中的一个      4
        //\\d{5} 五位数字           10001（前六位省市县地区）
        //\\d{2}                    91（年份）
        //((0[1-9])|(10|11|12))     01（月份）
        //(([0-2][1-9])|10|20|30|31)01（日期）
        //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
        //$结尾

        //判断第18位校验值
        if (matches) {
            if (idNumber.length == 18) {
                return try {
                    val charArray = idNumber.toCharArray()
                    //前十七位加权因子
                    val idCardWi = intArrayOf(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2)
                    //这是除以11后，可能产生的11位余数对应的验证码
                    val idCardY = arrayOf("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2")
                    var sum = 0
                    for (i in idCardWi.indices) {
                        val current = charArray[i].toString().toInt()
                        val count = current * idCardWi[i]
                        sum += count
                    }
                    val idCardLast = charArray[17]
                    val idCardMod = sum % 11
                    idCardY[idCardMod].equals(idCardLast.toString(), ignoreCase = true)
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
            }
        }
        return matches
    }
}