package com.example.dailytodo

class Note {

    var noteTitle: String = ""
    var dueDate: String = ""
    var noteDetail: String = ""


    constructor(noteTitle: String, dueDate: String, noteDetail: String) {
        this.noteTitle = noteTitle
        this.dueDate = dueDate
        this.noteDetail = noteDetail

    }


}