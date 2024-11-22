package ru.romanovdeveloper.damir_pracktik

class Teacher {
    var firstName: String
    var secondName: String
    var thirdName: String
    var specialization : String
    var description : String

    constructor(_firstName:String,_secondName:String,_thirdName:String,
                _specialization:String,_description:String){
        firstName = _firstName
        secondName =_secondName
        thirdName =_thirdName
        specialization =_specialization
        description =_description
    }
}