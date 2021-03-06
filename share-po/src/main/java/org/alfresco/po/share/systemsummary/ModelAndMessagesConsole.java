/*
 * #%L
 * share-po
 * %%
 * Copyright (C) 2005 - 2016 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.po.share.systemsummary;

import org.alfresco.po.RenderTime;
import org.alfresco.po.RenderWebElement;
import org.openqa.selenium.By;

/**
 * Created by olga.lokhach on 9/11/2014.
 */
public class ModelAndMessagesConsole  extends TenantConsole
{
    @RenderWebElement
    private final static By REPO_FIELD = By.cssSelector("input[name='repo-cmd']");
    @RenderWebElement
    private final static By EXECUTE_BUTTON = By.cssSelector("input[value='Execute']");

    @SuppressWarnings("unchecked")
    @Override
    public ModelAndMessagesConsole render(RenderTime timer)
    {
        webElementRender(timer);
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ModelAndMessagesConsole render()
    {
        return render(new RenderTime(maxPageLoadingTime));
    }
    /**
     * Method for send commands
     *
     * @param request String
     */
    public void sendCommand(String request)
    {
        findAndWait(REPO_FIELD, 60000).clear();
        findAndWait(REPO_FIELD).sendKeys(String.format("%s", request));
        findAndWait(EXECUTE_BUTTON).click();
    }
}
