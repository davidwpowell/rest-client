package com.prototype.restclient.configuration

import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class BeanConfigurationSpec extends Specification {

    BeanConfiguration beanConfiguration = new BeanConfiguration()

    def "Test restTemplate"() {
        when:
        RestTemplate restTemplate = beanConfiguration.restTemplate()

        then:
        0 * _

        and:
        restTemplate
    }
}
