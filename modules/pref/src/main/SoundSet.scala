package lila.pref

sealed class SoundSet private[pref] (val key: String, val name: String) {

  override def toString = key

  def cssClass = key
}

object SoundSet {

  val default = new SoundSet("standard", "Standard")

  val list = List(
    new SoundSet("silent", "Silent"),
    default,
    new SoundSet("piano", "Piano"),
    new SoundSet("nes", "NES"),
    new SoundSet("sfx", "SFX"),
    new SoundSet("futuristic", "Futuristic"),
    new SoundSet("robot", "Robot"),
    new SoundSet("music", "Pentatonic"),
    new SoundSet("shogi1", "Shogi1"),
    new SoundSet("shogi2", "Shogi2"),
    new SoundSet("speech", "Speech")
  )

  lazy val allByKey = list map { c =>
    c.key -> c
  } toMap
  lazy val allByName = list map { c =>
    c.name -> c
  } toMap

  def apply(key: String) = allByKey.getOrElse(key.toLowerCase, default)

  def contains(key: String) = allByKey contains key.toLowerCase

  def name2key(name: String): String =
    allByName.get(name).fold(name.toLowerCase)(_.key)
}
