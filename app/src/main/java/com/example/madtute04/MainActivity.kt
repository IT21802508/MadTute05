package com.example.madtute04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import com.example.madtute04.models.FormData
import com.example.madtute04.models.validations.validationResults

lateinit var edtStudentId: EditText
lateinit var spntv: Spinner
lateinit var spnsemester: Spinner
lateinit var btnconfirm: CheckBox
lateinit var btnagree: Button
lateinit var btnCancel: Button
var count = 0;


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtStudentId = findViewById(R.id.edtStudentId)
        spntv= findViewById(R.id.spnyear)
        spnsemester= findViewById(R.id.spnsemester)
        btnconfirm= findViewById(R.id.btnconfirm)
        btnagree= findViewById(R.id.cbAgree)
        btnCancel= findViewById(R.id.btnCancel)
    }


    fun displayAlert(title:String,message:String){

        var builder= AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Ok"){dialog,which ->

        }

        val dialog = builder.create()
        dialog.show()
    }

    fun btnSubmit(v: View){

        val myForm = FormData(

            edtStudentId.text.toString(),
            spntv.selectedItem.toString(),
            spnsemester.selectedItem.toString(),
            btnconfirm.isChecked


        )
        val studentIDvalidation = myForm.validateStudentId()
        val yearvalidation = myForm.validateYear()
        var semestervalidatioon=myForm.validateSemeseter()
        val cbAgreement =myForm.agree()


        when(studentIDvalidation){


            is validationResults.Valid->{

                count++
            }
            is validationResults.Invalid->{


                edtStudentId.error=studentIDvalidation.errorMessage
            }
            is validationResults.Empty->{


                edtStudentId.error=studentIDvalidation.errorMessage
            }
        }

        when(yearvalidation){


            is validationResults.Valid->{

                count++
            }
            is validationResults.Invalid->{


                edtStudentId.error=yearvalidation.errorMessage
            }
            is validationResults.Empty->{


                edtStudentId.error=yearvalidation.errorMessage
            }
        }

        when(semestervalidatioon){


            is validationResults.Valid->{

                count++
            }
            is validationResults.Invalid->{


                edtStudentId.error=semestervalidatioon.errorMessage
            }
            is validationResults.Empty->{


                edtStudentId.error=semestervalidatioon.errorMessage
            }
        }

        when(cbAgreement){


            is validationResults.Valid->{

                count++
            }
            is validationResults.Invalid->{


                edtStudentId.error=cbAgreement.errorMessage
            }
            is validationResults.Empty->{


                edtStudentId.error=cbAgreement.errorMessage
            }
        }

        if(count ==4){

            displayAlert("Success!","You have successfully registered")
        }





    }

}