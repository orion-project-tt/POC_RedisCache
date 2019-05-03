package rtl.tot.corp.mrex.prcn.provider.cmd.controllers;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rtl.tot.corp.mrex.prcn.provider.cmd.adapters.create.CreateProviderCommandImpl;
import rtl.tot.corp.mrex.prcn.provider.cmd.adapters.create.DecoratorCreateProviderCommandBus;
import rtl.tot.corp.mrex.prcn.provider.cmd.adapters.get.DecoratorGetProviderCommandBus;
import rtl.tot.corp.mrex.prcn.provider.cmd.adapters.get.GetProviderCommandImpl;
import rtl.tot.corp.mrex.prcn.provider.cmd.adapters.update.DecoratorUpdateProviderCommandBus;
import rtl.tot.corp.mrex.prcn.provider.cmd.adapters.update.UpdateProviderCommandImpl;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.domain.APIResponse;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.domain.EventProperties;
import rtl.tot.corp.mrex.prcn.provider.cmd.domain.Provider;
import rtl.tot.corp.mrex.prcn.provider.cmd.commons.constants.RestConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class ProviderController {


    @Autowired
    private HttpServletRequest context;

    @Autowired
    private EventProperties eventProperties;

    @Autowired
    private DecoratorCreateProviderCommandBus cmdCreateBus;

    @Autowired
    private DecoratorUpdateProviderCommandBus cmdUpdateBus;

    @Autowired
    private DecoratorGetProviderCommandBus cmdGetBus;

    @RequestMapping(value = "/mrex/prcn/v1.0/provider-catalog", method = RequestMethod.POST)
    @ApiOperation(value = "Create Provider", response = APIResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Country", value = "Country", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "Commerce", value = "Commerce", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "Channel", value = "Channel", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "Content-Type", value = "Content-Type", required = true, dataType = "string", paramType = "header")

    })
    public ResponseEntity<APIResponse> createProvider(
            @RequestBody Provider request
    ) {

        eventProperties.setChannel(context.getHeader("Channel"));
        eventProperties.setCommerce(context.getHeader("Commerce"));
        eventProperties.setCountry(context.getHeader("Country"));
        eventProperties.setMimeType(context.getHeader("Content-Type"));
        eventProperties.setVersion("1.0");

        log.info("Create Provider request.", request);
        try {

            CreateProviderCommandImpl cmd = new CreateProviderCommandImpl(request);

            if (cmdCreateBus.execute(cmd))
                log.info("Provider Created successful ", request.getRut());
            else {
                log.info("Provider not Created ", request.getRut());
                return new ResponseEntity<>(this.buildErrorRes("Provider not Created"), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {

            log.debug("Provider Created Exception ", request.getRut());
            return new ResponseEntity<>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.buildSuccessRes("Provider Created"), HttpStatus.OK);
    }

    @RequestMapping(value = "/mrex/prcn/v1.0/provider-catalog",
            method = RequestMethod.GET)
    @ApiOperation(value = "GET Provider", response = APIResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Country", value = "Country", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "Commerce", value = "Commerce", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "Channel", value = "Channel", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "Content-Type", value = "Content-Type", required = true, dataType = "string", paramType = "header")

    })
    public List<Provider> getProviders(
    ) {

        eventProperties.setChannel(context.getHeader("Channel"));
        eventProperties.setCommerce(context.getHeader("Commerce"));
        eventProperties.setCountry(context.getHeader("Country"));
        eventProperties.setMimeType(context.getHeader("Content-Type"));
        eventProperties.setVersion("1.0");

        log.info("Get Provider Cache request.");
        try {

            List<Provider> providerList = cmdGetBus.execute();

            if (providerList.isEmpty()) {
                log.info("Provider List is empty");
                return providerList;
            } else {
                log.info("Provider Retrieve successful ");
                return providerList;
            }

        } catch (Exception e) {
            log.error("Provider Retrieve Exception ");
            return new ArrayList<>();
        }

    }


    @RequestMapping(value = "/mrex/prcn/v1.0/provider-catalog",
            method = RequestMethod.PUT)
    @ApiOperation(value = "Update Provider", response = APIResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Country", value = "Country", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "Commerce", value = "Commerce", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "Channel", value = "Channel", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "Content-Type", value = "Content-Type", required = true, dataType = "string", paramType = "header")

    })
    public ResponseEntity<APIResponse> updateProvider(
            @RequestBody Provider request
    ) {

        eventProperties.setChannel(context.getHeader("Channel"));
        eventProperties.setCommerce(context.getHeader("Commerce"));
        eventProperties.setCountry(context.getHeader("Country"));
        eventProperties.setMimeType(context.getHeader("Content-Type"));
        eventProperties.setVersion("1.0");

        log.info("Update Provider request.", request);
        try {

            UpdateProviderCommandImpl cmd = new UpdateProviderCommandImpl(request);

            if (cmdUpdateBus.execute(cmd))
                log.info("Provider Updated successful ", request.getRut());
            else {
                log.info("Provider not Updated ", request.getRut());
                return new ResponseEntity<>(this.buildErrorRes("Provider not Updated"), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {

            log.debug("Provider Updated Exception ", request.getRut());
            return new ResponseEntity<>(this.buildErrorRes(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(this.buildSuccessRes("Provider Updated"), HttpStatus.OK);
    }


    private APIResponse buildSuccessRes(String msg) {
        APIResponse res = new APIResponse();
        res.setCode(RestConstants.SUCCESS_CODE);
        res.setType(RestConstants.SUCCESS_RESPONSE);
        res.setMessage(msg);
        return res;
    }

    /**
     * API Error response
     *
     * @return
     */
    private APIResponse buildErrorRes(String error) {
        APIResponse res = new APIResponse();
        res.setCode(RestConstants.ERROR_CODE);
        res.setType(RestConstants.SYSTEM_ERROR);
        res.setMessage(error);
        return res;
    }


}
