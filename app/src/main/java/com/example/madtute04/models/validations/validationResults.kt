package com.example.madtute04.models.validations

sealed class validationResults{



    data class Empty(val errorMessage:String):validationResults()
    object Valid:validationResults()
    data class Invalid(val errorMessage:String):validationResults()


}
