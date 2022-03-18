package com.avd1234.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun btnclick(view: View) {

        val buselect = view as Button
        var cellid = 0
        when (buselect.id) {
            R.id.button1 -> cellid = 1
            R.id.button2 -> cellid = 2
            R.id.button3 -> cellid = 3
            R.id.button4 -> cellid = 4
            R.id.button5 -> cellid = 5
            R.id.button6 -> cellid = 6
            R.id.button7 -> cellid = 7
            R.id.button8 -> cellid = 8
            R.id.button9 -> cellid = 9


        }

        // Log.d("btclick cellid ",cellid.toString())
        //Log.d("btnclick",buselect.id.toString())
        play(cellid, buselect)

    }

    var activeplayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun play(cellId: Int, buselect: Button) {

        if (activeplayer == 1) {

            buselect.text = "X"
            buselect.setBackgroundResource(R.color.colorAccent)
            player1.add(cellId)
            activeplayer = 2
            autoplay()

        } else {

            buselect.text = "O"
            buselect.setBackgroundResource(R.color.orange)
            player2.add(cellId)
            activeplayer = 1
        }
        buselect.isEnabled = false
        checkwinner()
    }

    private fun checkwinner() {

        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
        if (winner == 1) {
            player1wincounts += 1
            Toast.makeText(this, "Player1 win ", Toast.LENGTH_LONG).show()
            restart()
        } else if (winner == 2) {
            player2wincounts += 1
            Toast.makeText(this, "Player2 win ", Toast.LENGTH_LONG).show()
            restart()
        }
    }

    fun autoplay() {
        val emptycell = ArrayList<Int>()

        for (cellId in 1..9) {
            if (!(player1.contains(cellId) || (player2.contains(cellId)))) {
                emptycell.add(cellId)

            }
            if (emptycell.size == 0) {
                restart()
            }

        }
        val r = Random()
        val reindex = r.nextInt(emptycell.size)
        val cellId = emptycell[reindex]

        var buselect: Button?
        buselect = when (cellId) {
            1 -> button1
            2 -> button2
            3 -> button3
            4 -> button4
            5 -> button5
            6 -> button6
            7 -> button7
            8 -> button8
            9 -> button9
            else
            -> button1
        }
        play(cellId, buselect)

    }

    var player1wincounts = 0
    var player2wincounts = 0

    fun restart() {
        activeplayer = 1
        player1.clear()
        player2.clear()

        for (cellId in 1..9) {
            var buselect: Button? = when (cellId) {
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else
                -> button1
            }
            buselect!!.text = ""
            buselect.setBackgroundResource(R.color.white)
            buselect.isEnabled = true
        }
        Toast.makeText(
            this,
            "Player1win:$player1wincounts : Player2win:$player2wincounts",
            Toast.LENGTH_LONG
        ).show()
    }
}
