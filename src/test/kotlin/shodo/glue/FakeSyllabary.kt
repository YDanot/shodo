package shodo.glue

import shodo.Syllabary

class FakeSyllabary(private val map: Map<String, Char>) : Syllabary {

    override fun syllables(): Set<String> {
        return map.keys
    }

    override fun toKana(syllable: String): Char {
        return map.get(syllable)!!
    }
}