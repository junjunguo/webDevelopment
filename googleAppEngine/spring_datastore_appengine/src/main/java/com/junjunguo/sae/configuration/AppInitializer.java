//package com.junjunguo.sae.configuration;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
///**
// * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 25/10/15.
// */
//
//public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{AppConfiguration.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return null;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//
////    @Override
////    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
////        registration.setMultipartConfig(getMultipartConfigElement());
////    }
////
////    private MultipartConfigElement getMultipartConfigElement() {
////        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(Constant.LOCATION,
////                Constant.MAX_FILE_SIZE, Constant.MAX_REQUEST_SIZE, Constant.FILE_SIZE_THRESHOLD);
////        return multipartConfigElement;
////    }
//
//
//}
