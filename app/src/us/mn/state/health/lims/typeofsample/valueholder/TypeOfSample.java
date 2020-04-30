/**
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
* Copyright (C) The Minnesota Department of Health.  All Rights Reserved.
* 
* Contributor(s): CIRG, University of Washington, Seattle WA.
*/
package us.mn.state.health.lims.typeofsample.valueholder;

import us.mn.state.health.lims.common.services.LocalizationService;
import us.mn.state.health.lims.common.valueholder.BaseObject;
import us.mn.state.health.lims.common.valueholder.ValueHolder;
import us.mn.state.health.lims.localization.valueholder.Localization;

public class TypeOfSample extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String description;
	private String domain;
	private String localAbbreviation;
	private boolean isActive;
	private int sortOrder;
	private ValueHolder localization = new ValueHolder();

	public String getLocalAbbreviation() {
		return localAbbreviation;
	}

	public void setLocalAbbreviation(String localAbbreviation) {
		this.localAbbreviation = localAbbreviation;
	}

	public TypeOfSample() {
		super();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDomain() {
		return domain;
	}

	//@Override
	protected String getDefaultLocalizedName() {
		return LocalizationService.getLocalizedValue(getLocalization());
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Localization getLocalization() {
		return (Localization)localization.getValue();
	}

	public void setLocalization(Localization localization) {
		this.localization.setValue(localization);
	}
}