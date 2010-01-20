package com.exie.scalalib

import com.exie.mjeedom.User;

object UserFactory {
  def createUser(name: java.lang.String, birthDate: java.util.Date): User = {
    new User(name,birthDate)
  }
}
