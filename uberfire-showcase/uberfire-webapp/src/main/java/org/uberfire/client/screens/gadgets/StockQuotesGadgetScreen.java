/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.client.screens.gadgets;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.IsWidget;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;

@Dependent
@WorkbenchScreen(identifier = "StockQuotesGadget")
public class StockQuotesGadgetScreen {

    private static final String URL = "http://www.gmodules.com/ig/ifr?url=http://hosting.gmodules.com/ig/gadgets/file/100840413740199312943/stock-quotes.xml&amp;up_stockList=%5EGSPC%2C%5EN225%2C%5EHSI%2C%5ESTI%2C%5EFTSE%2C%5EGDAXI%2C%5EFCHI&amp;up_chart_bool=1&amp;up_font_size=12&amp;up_symbol_bool=0&amp;up_chart_period=2&amp;up_refresh_secs=30&amp;synd=open&amp;w=290&amp;h=300&amp;title=Stock+Quotes&amp;border=http%3A%2F%2Fwww.gmodules.com%2Fig%2Fimages%2F&amp;output=js";

    private Frame frame;

    @PostConstruct
    public void init() {
        frame = new Frame();
        frame.setWidth("100%");
        frame.setHeight("300px");
        frame.getElement().getStyle().setBorderWidth(0, Style.Unit.PX);
        frame.setUrl(UriUtils.fromString(GWT.getModuleBaseURL() + "google.gadget?src=" + URL).asString());
    }

    @WorkbenchPartTitle
    public String getName() {
        return "Stock Quotes";
    }

    @WorkbenchPartView
    public IsWidget getView() {
        return frame;
    }
}
