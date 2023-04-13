package com.ritik.myapplication

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity() : AppCompatActivity(), Parcelable {
    var btn1: Button? = null;
    var btn2:android.widget.Button? = null
    var btn3:android.widget.Button? = null
    var btn4:android.widget.Button? = null
    var btn5:android.widget.Button? = null
    var btn6:android.widget.Button? = null
    var btn7:android.widget.Button? = null
    var btn8:android.widget.Button? = null
    var btn9:android.widget.Button? = null
    var b1: String? = null
    var b2:kotlin.String? = null
    var b3:kotlin.String? = null
    var b4:kotlin.String? = null
    var b5:kotlin.String? = null
    var b6:kotlin.String? = null
    var b7:kotlin.String? = null
    var b8:kotlin.String? = null
    var b9:kotlin.String? = null
    var count = 0
    var flag = 0

    constructor(parcel: Parcel) : this() {
        b1 = parcel.readString()
        b2 = parcel.readString()
        b3 = parcel.readString()
        b4 = parcel.readString()
        b5 = parcel.readString()
        b6 = parcel.readString()
        b7 = parcel.readString()
        b8 = parcel.readString()
        b9 = parcel.readString()
        count = parcel.readInt()
        flag = parcel.readInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        FindID()
    }

    fun FindID() {
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
    }

    fun Check(view: View) {
        val btnCurrent = view as Button
        if (btnCurrent.text.toString() == "") {
            count++
            if (flag == 0) {
                btnCurrent.text = "X"
                flag = 1
            } else {
                btnCurrent.text = "0"
                flag = 0
            }
            if (count > 4) {
                b1 = btn1!!.text.toString()
                b2 = btn2!!.text.toString()
                b3 = btn3!!.text.toString()
                b4 = btn4!!.text.toString()
                b5 = btn5!!.text.toString()
                b6 = btn6!!.text.toString()
                b7 = btn7!!.text.toString()
                b8 = btn8!!.text.toString()
                b9 = btn9!!.text.toString()

//                Row Wise Check:
                if (b1 == b2 && b2 == b3 && b1 != "") {
                    Toast.makeText(this, "Winner is: $b1", Toast.LENGTH_SHORT).show()
                    newGame()
                } else if (b4 == b5 && b5 == b6 && b4 != "") {
                    Toast.makeText(this, "Winner is: $b4", Toast.LENGTH_SHORT).show()
                    newGame()
                } else if (b7==b8  && b8 == b9 && b7 != "") {
                    Toast.makeText(this, "Winner is: $b7", Toast.LENGTH_SHORT).show()
                    newGame()
                } else if (b1 == b4 && b4 == b7 && b1 != "") {
                    Toast.makeText(this, "Winner is: $b1", Toast.LENGTH_SHORT).show()
                    newGame()
                } else if (b2 == b5 && b5 == b8 && b2 != "") {
                    Toast.makeText(this, "Winner is: $b2", Toast.LENGTH_SHORT).show()
                    newGame()
                } else if (b3 == b6 && b6 == b9 && b3 != "") {
                    Toast.makeText(this, "Winner is: $b3", Toast.LENGTH_SHORT).show()
                    newGame()
                } else if (b1 == b5 && b5 == b9 && b1 != "") {
                    Toast.makeText(this, "Winner is: $b1", Toast.LENGTH_SHORT).show()
                    newGame()
                } else if (b3 == b5 && b5 == b7 && b3 != "") {
                    Toast.makeText(this, "Winner is: $b3", Toast.LENGTH_SHORT).show()
                    newGame()
                } else if (b1 != "" && b2 != "" && b3 != "" && b4 != "" && b5 != "" && b6 != "" && b7 != "" && b8 != "" && b9 != "") {
                    Toast.makeText(this, "Game is Draw!", Toast.LENGTH_SHORT).show()
                    newGame()
                }
            }
        }
    }

    fun newGame() {
        btn1!!.text = ""
        btn2!!.text = ""
        btn3!!.text = ""
        btn4!!.text = ""
        btn5!!.text = ""
        btn6!!.text = ""
        btn7!!.text = ""
        btn8!!.text = ""
        btn9!!.text = ""
        flag = 0
        count = 0
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(b1)
        parcel.writeString(b2)
        parcel.writeString(b3)
        parcel.writeString(b4)
        parcel.writeString(b5)
        parcel.writeString(b6)
        parcel.writeString(b7)
        parcel.writeString(b8)
        parcel.writeString(b9)
        parcel.writeInt(count)
        parcel.writeInt(flag)
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel = parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }


}
