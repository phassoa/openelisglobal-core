/*
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations under
 * the License.
 *
 * The Original Code is OpenELIS code.
 *
 * Copyright (C) ITECH, University of Washington, Seattle WA.  All Rights Reserved.
 */

package us.mn.state.health.lims.testconfiguration.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.services.DisplayListService;
import us.mn.state.health.lims.common.services.LocalizationService;
import us.mn.state.health.lims.common.services.TypeOfSampleService;
import us.mn.state.health.lims.common.util.ConfigurationProperties;
import us.mn.state.health.lims.typeofsample.valueholder.TypeOfSample;

public class SampleTypeCreateAction extends BaseAction {
    public static final String NAME_SEPARATOR = "$";
    //@Override
    protected ActionForward performAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ((DynaValidatorForm)form).initialize(mapping);
        PropertyUtils.setProperty(form, "existingSampleTypeList", DisplayListService.getList(DisplayListService.ListType.SAMPLE_TYPE_ACTIVE));
        PropertyUtils.setProperty(form, "inactiveSampleTypeList", DisplayListService.getList(DisplayListService.ListType.SAMPLE_TYPE_INACTIVE));
        List<TypeOfSample> typeOfSamples = TypeOfSampleService.getAllTypeOfSamples();
        PropertyUtils.setProperty(form, "existingEnglishNames", getExistingTestNames(typeOfSamples, ConfigurationProperties.LOCALE.ENGLISH));
        PropertyUtils.setProperty(form, "existingFrenchNames", getExistingTestNames(typeOfSamples, ConfigurationProperties.LOCALE.FRENCH));

        return mapping.findForward(FWD_SUCCESS);
    }

    private String getExistingTestNames(List<TypeOfSample> typeOfSamples, ConfigurationProperties.LOCALE locale) {
        StringBuilder builder = new StringBuilder(NAME_SEPARATOR);

        for( TypeOfSample typeOfSample : typeOfSamples){
            builder.append(LocalizationService.getLocalizationValueByLocal(locale, typeOfSample.getLocalization()));
            builder.append(NAME_SEPARATOR);
        }

        return builder.toString();
    }


    //@Override
    protected String getPageTitleKey() {
        return null;
    }

    //@Override
    protected String getPageSubtitleKey() {
        return null;
    }
}
