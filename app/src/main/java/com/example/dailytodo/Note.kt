package com.example.dailytodo

class Note {

    var noteTitle: String = ""
    var dueDate: String = ""
    var noteDetail: String = ""
    var isDone: Boolean = false


    constructor(noteTitle: String, dueDate: String, noteDetail: String, isDone: Boolean ) {
        this.noteTitle = noteTitle
        this.dueDate = dueDate
        this.noteDetail = noteDetail
        this.isDone = isDone

    }
}