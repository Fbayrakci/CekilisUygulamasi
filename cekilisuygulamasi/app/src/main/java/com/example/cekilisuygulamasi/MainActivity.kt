package com.example.cekilisuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import com.example.cekilisuygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var participantList = mutableListOf<Participant>()
    var winnerParticipant = Participant( fullName = "", dscName = "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rollthewinnerButton.setOnClickListener {rollTheWinner()}
        binding.addpartCPantButton.setOnClickListener {addParticipant()}
    }

    fun addParticipant() {

        var fullNameString = binding.fullnameeditText.text.toString()
        var dscNameString = binding.dscnameedit.text.toString()

        if (TextUtils.isEmpty(fullNameString) || TextUtils.isEmpty(dscNameString)){
            binding.infotext.text = "Add more participants before rolling."
        }
        else {
            val participant = Participant(fullNameString, dscNameString)
            participantList.add(participant)
            binding.infotext.text = "${participant.fullName} added to list"
        }
        binding.fullnameeditText.text.clear()
        binding.dscnameedit.text.clear()
    }

    fun rollTheWinner() {
        if (participantList.count() == 0){
            binding.infotext.text = "Add more participants before rolling."
        }
        else{
            winnerParticipant = participantList.random()
            binding.winnerfullnameTextView.text = winnerParticipant.fullName
            binding.winnerdscnameTextView.text = winnerParticipant.dscName
        }

    }

    class Participant(val fullName : String, val dscName : String) {

    }

    }