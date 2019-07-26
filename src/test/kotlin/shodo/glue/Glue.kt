package shodo.glue

import shodo.Hiragana
import shodo.Syllabary

class Glue {

    var syllabary: Syllabary = Hiragana()

    fun given_syllabary_is(s: String) {
        val syllabaryMap = mutableMapOf<String, Char>()
        s.split("|").forEach({
            val entry = it.trim().split("->")
            syllabaryMap.put(entry[0], entry[1].first())
        })
        syllabary = FakeSyllabary(syllabaryMap)
    }

    fun toKana(syllable: String): Char {
        return syllabary.toKana(syllable)
    }

}