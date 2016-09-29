// Copyright (C) 2016-2017 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package onextent.blueql

import java.io.File

trait Config {

  def fieldName(name: String): String = {
    Character.toLowerCase(name.charAt(0)) + name.substring(1)
  }
  def caseName(name: String): String = {
    Character.toUpperCase(name.charAt(0)) + name.substring(1) + "Data"
  }

  def pdir(): String = {
    val regex = "\\.".r
    val pkgpath = regex.replaceAllIn(property(PACKAGE_PROP), "/")
    val pkgdir = s"${property(OUT_DIR_PROP)}/src/main/scala/${pkgpath}"
    new File(s"${pkgdir}").mkdirs()
    pkgdir
  }

  // keys
  def PACKAGE_PROP: String = "PACKAGE"
  def FILE_PROP: String = "FILE"
  def OUT_DIR_PROP: String = "OUT"

  // set / get
  def property(name: String, value: String): Unit = System.setProperty(name, value)
  def property(name: String): String = System.getProperty(name)

}

