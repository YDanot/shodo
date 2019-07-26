package shodo

class Shodo(val syllabary: Syllabary = Hiragana()) {

    fun shodo(word: String): String {
        return Word(word).splitInSyllables(syllabary.syllables())
            .map { toKana(it)}
            .reduce({ s1, s2 -> s1 + s2 })
    }

    fun toKana(syllable: String): String {
        return syllabary.toKana(syllable.toLowerCase()).toString()
    }
}