package shodo

/*
https://en.wikipedia.org/wiki/Syllabary
 */
interface Syllabary {

    fun syllables(): Set<String>

    fun toKana(syllable: String): Char
}
