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
                paramsObj.entity = Entity.findByTitle(titleVal)
                if (!paramsObj.entity){
                    response.sendError(400, "Cannot find entity with the title ${titleVal}")
                }
            }
        }
        paramsObj
    }
}
