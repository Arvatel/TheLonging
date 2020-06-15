package character

import Environment
//TODO delete setter
class Character (val environment: Environment) {
    val brain : Brain = Brain(this, environment)
    val params : CharacterParams = CharacterParams()
    fun onCreate(){
        brain.onCreate()
    }

}