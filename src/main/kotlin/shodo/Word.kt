package shodo

import kotlin.math.min

class Word(val word: String) {
    init {
        if (!"""[a-zA-Z]+""".toRegex().matches(word)) {
            throw IllegalArgumentException("$word is not a word")
        }
    }

    fun splitInSyllables(syllableDictionary: Set<String>): List<String> {
        var wordCopy = word.toLowerCase()
        val syllables = mutableListOf<String>()
        while (wordCopy.isNotEmpty()) {
            val syllable = findNextSyllable(wordCopy, syllableDictionary)
            syllables.add(syllable)
            wordCopy = wordCopy.removePrefix(syllable)
        }
        return syllables
    }

    private fun findNextSyllable(word: String, syllableDictionary: Set<String>): String {
        for (i in min(syllableDictionary.maxlength(), word.length) downTo 1) {
            val syllable = word.substring(0, i)
            if (syllableDictionary.contains(syllable)) {
                return syllable
            }
        }
        throw IllegalArgumentException("No syllable found in firsts characters of $word")
    }

    private fun Set<String>.maxlength(): Int {
        return this.map { it.length }.max()!!
    }
}