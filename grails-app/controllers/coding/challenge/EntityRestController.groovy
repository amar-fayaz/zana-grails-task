package coding.challenge

import grails.rest.RestfulController

class EntityRestController extends RestfulController{
    static responseFormats = ["json", "xml"]

    EntityRestController() {
        super(Entity)
    }
}
