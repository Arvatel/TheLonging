package engine

interface MicroAction {
    fun isInterrupted() : Boolean
    fun getDescription() : String
}