package coding.challenge

import grails.converters.JSON
import grails.rest.RestfulController

class ContentRestController extends RestfulController {
    static responseFormats = ["json", "xml"]

    ContentRestController() {
        super(Content)
    }

    @Override
    def getObjectToBind() {
        Map paramsObj = JSON.parse(request)
        if (paramsObj.entity) {
            if (paramsObj.entity.title){
                String titleVal = paramsObj.entity.title
                Entity returnVal = Entity.findByTitle(titleVal)

                if (!returnVal){
                    if (request.method == "POST" || request.method == "PUT"){
                        paramsObj.entity = new Entity(paramsObj.entity).save(failOnError:"true")
                    } else {
                        response.sendError(400, "Cannot find entity with the title ${titleVal}")
                    }
                } else {
                    paramsObj.entity = returnVal
                }
            }
        }
        paramsObj
    }
}
