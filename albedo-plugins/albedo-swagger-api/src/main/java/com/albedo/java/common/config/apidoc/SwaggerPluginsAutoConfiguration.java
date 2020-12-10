package com.albedo.java.common.config.apidoc;

import com.albedo.java.common.core.vo.PageModel;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.schema.TypeNameExtractor;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author somewhere
 * @description
 * @date 2020/5/31 17:14
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnBean({Docket.class})
@AutoConfigureAfter({SwaggerAutoConfiguration.class})
public class SwaggerPluginsAutoConfiguration {

	@Configuration
	@ConditionalOnClass({PageModel.class})
	public static class MybatisPlusPagePluginConfiguration {
		public MybatisPlusPagePluginConfiguration() {
		}

		@Bean
		@ConditionalOnMissingBean
		public PageableParameterBuilderPlugin pageableParameterBuilderPlugin(TypeNameExtractor typeNameExtractor, TypeResolver typeResolver) {
			return new PageableParameterBuilderPlugin(typeNameExtractor, typeResolver);
		}
	}
}
