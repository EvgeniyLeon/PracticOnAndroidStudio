package ru.romanovdeveloper.damir_pracktik

class Administration {
    var firstName: String
    var secondName: String
    var thirdName: String
    var post : String
    var description : String

    constructor(_firstName:String,_secondName:String,_thirdName:String,
                _post:String,_description:String){
        firstName = _firstName
        secondName =_secondName
        thirdName =_thirdName
        post =_post
        description =_description
    }
}