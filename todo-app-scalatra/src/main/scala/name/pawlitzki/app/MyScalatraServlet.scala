package name.pawlitzki.app

import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}
