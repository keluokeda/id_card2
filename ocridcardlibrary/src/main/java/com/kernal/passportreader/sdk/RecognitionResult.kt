package com.kernal.passportreader.sdk

import kernal.idcard.android.ResultMessage
import java.io.Serializable

sealed class RecognitionResult : Serializable {
    data class IDCardResult(
        /**
         * 姓名
         */
        val name: String,
        /**
         * 性别
         */
        val gender: String,
        /**
         * 民族
         */
        val nationality: String,
        /**
         * 出生日期
         */
        val birthday: String,
        /**
         * 住址
         */
        val address: String,

        /**
         * 身份证号码
         */
        val IDNumber: String
    ) : RecognitionResult() {
        companion object {
            fun fromResultMessage(resultMessage: ResultMessage): IDCardResult {


                return IDCardResult(
                    name = resultMessage.GetRecogResult[1],
                    gender = resultMessage.GetRecogResult[2],
                    nationality = resultMessage.GetRecogResult[3],
                    birthday = resultMessage.GetRecogResult[4],
                    address = resultMessage.GetRecogResult[5],
                    IDNumber = resultMessage.GetRecogResult[6]
                )
            }
        }
    }

    data class RecognitionError(val error: String) : RecognitionResult()

    data class VehicleLicenseResult(
        /**
         * 号牌号码
         */
        val plateNo: String,

        /**
         * 小型普通客车
         */
        val vehicleType: String,

        /**
         * 所有人
         */
        val owner: String,

        /**
         * 住址
         */
        val address: String,

        /**
         * 使用性质
         */
        val useCharacter: String,

        /**
         * 使用型号
         */
        val model: String,

        /**
         * 车辆识别代号
         */
        val vin: String,

        /**
         * 发动机号码
         */
        val engineNo: String,

        /**
         * 注册日期
         */
        val registerDate: String,

        /**
         * 发证日期
         */
        val issueDate: String
    ) : RecognitionResult() {
        companion object {
            fun fromResultMessage(resultMessage: ResultMessage): VehicleLicenseResult {

                val array = resultMessage.GetRecogResult

                return VehicleLicenseResult(
                    plateNo = array[1],
                    vehicleType = array[2],
                    owner = array[3],
                    address = array[4],
                    useCharacter = array[10],
                    model = array[5],
                    vin = array[6],
                    engineNo = array[7],
                    registerDate = array[8],
                    issueDate = array[9]
                )
            }
        }
    }
}
