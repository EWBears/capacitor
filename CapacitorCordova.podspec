Pod::Spec.new do |s|
  s.name         = "CapacitorCordova"
  s.module_name = 'Cordova'
  s.version      = "0.0.1"
  s.summary      = "Capacitor Cordova Compatibility Layer"
  s.homepage     = "https://ionicframework.com"
  s.license      = 'MIT'
  s.authors      = { 'Ionic Team' => 'hi@ionicframework.com' }
  s.source       = { :git => 'https://github.com/ionic-team/capacitor', :tag => s.version }
  s.platform     = :ios, 10.0
  s.source_files = 'ios/CapacitorCordova/**/*.{h,m}'
  s.public_header_files = 'ios/CapacitorCordova/CapacitorCordova/Classes/Public/*.h'
  s.requires_arc = true
  s.framework    = "WebKit"
end