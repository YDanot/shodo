package shodo

typealias Kana = Char

class Hiragana : Syllabary {

    override fun syllables(): Set<String> {
        return dictionary().keys
    }

    override fun toKana(syllable: String): Kana {
        return dictionary().getOrElse(syllable, { throw IllegalArgumentException("no kana correspond to $syllable") })
    }

    private fun dictionary(): Map<String, Kana> {
        return mapOf(
            Pair("a",'あ'),
            Pair("i",'い'),
            Pair("u",'う'),
            Pair("e",'え'),
            Pair("o",'お'),
            Pair("ka",'か'),
            Pair("ki",'き'),
            Pair("ku",'く'),
            Pair("ke",'け'),
            Pair("ko",'こ'),
            Pair("sa",'さ'),
            Pair("shi",'し'),
            Pair("su",'す'),
            Pair("se",'せ'),
            Pair("so",'そ'),
            Pair("ta",'た'),
            Pair("chi",'ち'),
            Pair("tsu",'つ'),
            Pair("te",'て'),
            Pair("to",'と'),
            Pair("na",'な'),
            Pair("ni",'に'),
            Pair("nu",'ぬ'),
            Pair("ne",'ね'),
            Pair("no",'の'),
            Pair("ha",'は'),
            Pair("hi",'ひ'),
            Pair("fu",'ふ'),
            Pair("he",'へ'),
            Pair("ho",'ほ'),
            Pair("ma",'ま'),
            Pair("mi",'み'),
            Pair("mu",'む'),
            Pair("me",'め'),
            Pair("mo",'も'),
            Pair("ya",'や'),
            Pair("yu",'ゆ'),
            Pair("yo",'よ'),
            Pair("ra",'ら'),
            Pair("ri",'り'),
            Pair("ru",'る'),
            Pair("re",'れ'),
            Pair("ro",'ろ'),
            Pair("wa",'わ'),
            Pair("wi",'ゐ'),
            Pair("we",'ゑ'),
            Pair("wo",'を'),
            Pair("n",'ん')
        )
    }
}



