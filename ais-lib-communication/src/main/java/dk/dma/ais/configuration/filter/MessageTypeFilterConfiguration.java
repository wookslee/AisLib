/* Copyright (c) 2011 Danish Maritime Authority.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.dma.ais.configuration.filter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dk.dma.ais.filter.IPacketFilter;
import dk.dma.ais.filter.MessageTypeFilter;

@XmlRootElement
public class MessageTypeFilterConfiguration extends FilterConfiguration {

    private List<Integer> messageTypes = new ArrayList<>();
    private boolean disallowed;

    public MessageTypeFilterConfiguration() {

    }

    @XmlElement(name = "message_type")
    public List<Integer> getMessageTypes() {
        return messageTypes;
    }

    public void setMessageTypes(List<Integer> messageTypes) {
        this.messageTypes = messageTypes;
    }

    public boolean isDisallowed() {
        return disallowed;
    }

    public void setDisallowed(boolean disallowed) {
        this.disallowed = disallowed;
    }

    @Override
    public IPacketFilter getInstance() {
        MessageTypeFilter filter = new MessageTypeFilter();
        filter.setDisallowed(disallowed);
        for (Integer type : messageTypes) {
            filter.getMessageTypes().add(type);            
        }
        return filter;
    }

}
