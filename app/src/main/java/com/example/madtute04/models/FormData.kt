package com.example.madtute04.models

import com.example.madtute04.models.validations.validationResults
import com.example.madtute04.models.validations.validationResults.*

class FormData (


    private var studentID:String,
    private var year:String,
    private var semester:String,
    private  var agree:Boolean,


    ) {


    fun validateStudentId(): validationResults {
        return if (studentID.isEmpty()) {
            Empty("Student id is empty")
        } else if (!studentID.startsWith("IT")) {
            Invalid("Student id is invalid")
        } else if (studentID.length < 10) {
            Invalid("Student id is invalid")

        } else {
            Valid


        }


    }


    fun validateYear(): validationResults{



        return if (year.isEmpty()){


            validationResults.Empty("Empty year")
        }
        else{
            validationResults.Valid
        }
    }


    fun validateSemeseter(): validationResults{


        return if(semester.isEmpty()){

            validationResults.Empty("Empty semeseter")
        }
        else{
            validationResults.Valid
        }
    }

    fun agree():validationResults{

        return if(agree){

            validationResults.Valid
        }else{

            validationResults.Invalid("must agree to terms and conditions")
        }
    }

}



