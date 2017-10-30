webpackJsonp([3],{

/***/ 100:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return InicioPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/**
 * Generated class for the InicioPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var InicioPage = (function () {
    function InicioPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    InicioPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad InicioPage');
    };
    return InicioPage;
}());
InicioPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-inicio',template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/inicio/inicio.html"*/'<!--\n  Generated template for the InicioPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n    <ion-navbar>\n      <button ion-button menuToggle>\n        <ion-icon name="menu"></ion-icon>\n      </button>\n      <ion-title>Inicio</ion-title>\n    </ion-navbar>\n  </ion-header>\n  \n  <ion-content>\n    <ion-list>\n      <!-- ESTO TA RARO -->\n      <button ion-item *ngFor="let item of items" (click)="itemSelected(item)">\n        {{ item }}\n      </button>\n    </ion-list>\n  </ion-content>\n\n\n\n'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/inicio/inicio.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */]])
], InicioPage);

//# sourceMappingURL=inicio.js.map

/***/ }),

/***/ 101:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ReservasPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/**
 * Generated class for the ReservasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var ReservasPage = (function () {
    function ReservasPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.items = [
            { id: 1, titulo: "Yoga", img: "../assets/imgs/clasesYoga.jpg", instructor: "Estela Rodrigues", fecha: "24/10/2017 3:00 pm", duracion: 60 },
            { id: 2, titulo: "Boceo", img: "../assets/imgs/clasesBoxeo.jpg", instructor: "Jesus Rodriguez", fecha: "30/10/2017  3:00 pm", duracion: 60 },
            { id: 3, titulo: "KickBoxing", img: "../assets/imgs/claseKickboxing.jpg", instructor: "Marcos Rodriguez", fecha: "7/11/2017 3:00 pm", duracion: 60 },
        ];
    }
    ReservasPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ReservasPage');
    };
    return ReservasPage;
}());
ReservasPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-reservas',template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/reservas/reservas.html"*/'<!--\n  Generated template for the ReservasPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n  <ion-navbar>\n    <button ion-button menuToggle>\n         <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>Reservas</ion-title>\n  </ion-navbar>\n</ion-header>\n\n\n<ion-content padding>\n    <ion-list>\n        <ion-item>\n          <ion-avatar item-start>\n              <img src="../assets/imgs/clasesYoga.jpg">\n          </ion-avatar>\n          <h2>Yoga</h2>\n          <h3>Estela Rodrigues</h3>\n          <p>24/10/2017 3:00 pm</p>\n          <p>Duracion: 60 min</p>\n          <button ion-button icon-only>\n              <ion-icon name="trash"></ion-icon>\n          </button>\n        </ion-item>\n        <ion-item>\n            <ion-avatar item-start>\n                <img src="../assets/imgs/clasesBoxeo.jpeg">\n            </ion-avatar>\n          <h2>Boxeo</h2>\n          <h3>Jesus Rodriguez</h3>\n          <p>30/10/2017 3:00 pm</p>\n          <p>Duracion: 60 min</p>\n          <button ion-button icon-only>\n              <ion-icon name="trash"></ion-icon>\n          </button>\n        </ion-item>\n        <ion-item>\n            <ion-avatar item-start>\n                <img src="../assets/imgs/claseKickboxing.png">\n            </ion-avatar>\n            <ion-item>\n                <h2>KickBoxing</h2>\n                <h3>Marcos Rodriguez</h3>\n                <p>7/11/2017 3:00 pm</p>\n                <p>Duracion: 60 min</p>\n                <button ion-button icon-only>\n                    <ion-icon name="trash"></ion-icon>\n                </button>\n              </ion-item>\n            </ion-item>\n      </ion-list>\n</ion-content>\n\n<!-- AUN NO SE SI FUNCIONA ...  ESTOY OFFLINE\n<ion-content>\n    <ion-list>-->\n        <!--  Hay que buscar la manera de eliminar el item o ocultarlo al eliminar la reserva\n        <ion-item *ngFor="let item of items">\n            <ion-avatar>\n                <img src="{{item.img}}" alt="">\n            </ion-avatar>\n            <h2>{{item.titulo}}</h1>\n            <h3>{{item.instructor}}</h3>\n            <p>{{item.fecha}}</p>\n            <p>Duracion: {{item.duracion}} min</p>\n            <button ion-button icon-only (click)="eliminarReserva(item.id)"><ion-icon name="trash"></ion-icon></button>\n        </ion-item>\n    </ion-list>\n</ion-content>\n-->\n'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/reservas/reservas.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */]])
], ReservasPage);

//# sourceMappingURL=reservas.js.map

/***/ }),

/***/ 110:
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = 110;

/***/ }),

/***/ 151:
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"../pages/clases/clases.module": [
		264,
		2
	],
	"../pages/inicio/inicio.module": [
		265,
		1
	],
	"../pages/reservas/reservas.module": [
		266,
		0
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids)
		return Promise.reject(new Error("Cannot find module '" + req + "'."));
	return __webpack_require__.e(ids[1]).then(function() {
		return __webpack_require__(ids[0]);
	});
};
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
webpackAsyncContext.id = 151;
module.exports = webpackAsyncContext;

/***/ }),

/***/ 195:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__ = __webpack_require__(196);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__app_module__ = __webpack_require__(214);


Object(__WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_1__app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 214:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser__ = __webpack_require__(29);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_component__ = __webpack_require__(255);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__ = __webpack_require__(191);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ionic_native_splash_screen__ = __webpack_require__(194);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__pages_inicio_inicio__ = __webpack_require__(100);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__pages_clases_clases__ = __webpack_require__(99);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__pages_reservas_reservas__ = __webpack_require__(101);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};









var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* MyApp */],
            __WEBPACK_IMPORTED_MODULE_6__pages_inicio_inicio__["a" /* InicioPage */],
            __WEBPACK_IMPORTED_MODULE_7__pages_clases_clases__["a" /* ClasesPage */],
            __WEBPACK_IMPORTED_MODULE_8__pages_reservas_reservas__["a" /* ReservasPage */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["c" /* IonicModule */].forRoot(__WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* MyApp */], {}, {
                links: [
                    { loadChildren: '../pages/clases/clases.module#ClasesPageModule', name: 'ClasesPage', segment: 'clases', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/inicio/inicio.module#InicioPageModule', name: 'InicioPage', segment: 'inicio', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/reservas/reservas.module#ReservasPageModule', name: 'ReservasPage', segment: 'reservas', priority: 'low', defaultHistory: [] }
                ]
            })
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_2_ionic_angular__["a" /* IonicApp */]],
        entryComponents: [
            __WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* MyApp */],
            __WEBPACK_IMPORTED_MODULE_6__pages_inicio_inicio__["a" /* InicioPage */],
            __WEBPACK_IMPORTED_MODULE_7__pages_clases_clases__["a" /* ClasesPage */],
            __WEBPACK_IMPORTED_MODULE_8__pages_reservas_reservas__["a" /* ReservasPage */]
        ],
        providers: [
            __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__["a" /* StatusBar */],
            __WEBPACK_IMPORTED_MODULE_5__ionic_native_splash_screen__["a" /* SplashScreen */],
            { provide: __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ErrorHandler */], useClass: __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["b" /* IonicErrorHandler */] }
        ]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ 255:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MyApp; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__ = __webpack_require__(191);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(194);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__pages_inicio_inicio__ = __webpack_require__(100);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__pages_clases_clases__ = __webpack_require__(99);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__pages_reservas_reservas__ = __webpack_require__(101);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var MyApp = (function () {
    function MyApp(platform, statusBar, splashScreen) {
        this.rootPage = __WEBPACK_IMPORTED_MODULE_4__pages_inicio_inicio__["a" /* InicioPage */];
        this.pages = [
            { titulo: 'Inicio', component: __WEBPACK_IMPORTED_MODULE_4__pages_inicio_inicio__["a" /* InicioPage */], icon: 'home' },
            { titulo: 'Clases', component: __WEBPACK_IMPORTED_MODULE_5__pages_clases_clases__["a" /* ClasesPage */], icon: 'bicycle' },
            { titulo: 'Reservas', component: __WEBPACK_IMPORTED_MODULE_6__pages_reservas_reservas__["a" /* ReservasPage */], icon: 'calendar' },
        ];
        platform.ready().then(function () {
            // Okay, so the platform is ready and our plugins are available.
            // Here you can do any higher level native things you might need.
            statusBar.styleDefault();
            splashScreen.hide();
        });
    }
    MyApp.prototype.goToPage = function (page) {
        this.nav.setRoot(page);
    };
    return MyApp;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_14" /* ViewChild */])('NAV'),
    __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["e" /* Nav */])
], MyApp.prototype, "nav", void 0);
MyApp = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/app/app.html"*/'\n<ion-menu [content]="NAV">\n    <ion-content>\n        <ion-list>\n            <button ion-item *ngFor="let page of pages" (click)="goToPage(page.component)" munuClose>\n                <ion-icon item-left name="{{page.icon}}"></ion-icon>\n                {{page.titulo}}\n            </button>\n        </ion-list>\n    </ion-content>\n</ion-menu>\n    \n<ion-nav #NAV [root]="rootpage"></ion-nav>'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/app/app.html"*/
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* Platform */], __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__["a" /* StatusBar */], __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */]])
], MyApp);

//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ 99:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ClasesPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(31);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/* AUN NO SE SI FUNCIONA -- ESTOY OFFLINE
import ParticularPage from '../particular/partiular';
*/
/**
 * Generated class for the ClasesPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var ClasesPage = (function () {
    /* AUN NO SE SI FUNCIONA -- ESTOY OFFLINE
    public items: Array<{id: number, titulo: string, descripion: string, img:string, instructor:string, fecha: string, duracion: number}>;
    */
    function ClasesPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        /*  AUN NO SE SI FUNCIONA -- ESTOY OFFLINE
        this.items = [
          {id: 1, titulo:"Yoga", descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesYoga.jpg", instructor:"Estela Rodriguez", fecha:"24/10/2017 3:00 pm", duracion: 60},
          {id: 2,titulo:"Spinning",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/claseSpinning.jpg", instructor:"Maria Josefa", fecha:"26/10/2017 3:00 pm, duracion: 60},
          {id: 3,titulo:"Defensa Personal",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesDefensaPersonal.jpeg", instructor:"Pedro Alvarez", fecha:"28/10/2017 3:00 pm, duracion: 60},
          {id: 4,titulo:"Boxeo",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesBoxeo.jpeg", instructor:"Jesus Rodriguez", fecha:"30/10/2017 3:00 pm, duracion: 60},
          {id: 5,titulo:"KickBoxing",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/claseKickboxing.png", instructor:"Marcos Rodriguez", fecha:"7/11/2017 3:00 pm, duracion: 60}
        ];*/
    }
    ClasesPage.prototype.newFunction = function () {
        return {};
    };
    ClasesPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ClasesPage');
    };
    return ClasesPage;
}());
ClasesPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-clases',template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/clases/clases.html"*/'<!--\n  Generated template for the ClasesPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n  <button ion-button menuToggle>\n    <ion-icon name="menu"></ion-icon>\n  </button>\n  <ion-navbar>\n    <ion-title>Clases</ion-title>\n  </ion-navbar>\n\n</ion-header>\n\n<ion-content padding>\n    <ion-list>\n        <ion-item>\n          <ion-thumbnail item-start>\n            <img src="../assets/imgs/clasesYoga.jpg">\n          </ion-thumbnail>\n          <h2>Yoga</h2>\n          <p>Inst: Estela Rodrigues</p>\n          <p>24/10/2017  3:00 pm</p>\n          <p>Duracion: 60 min</p>          \n          <button ion-button clear item-end>\n            <ion-icon name="add-circle"></ion-icon>\n          </button>\n        </ion-item>\n        <ion-item>\n            <ion-thumbnail item-start>\n              <img src="../assets/imgs/claseSpinning.jpg">\n            </ion-thumbnail>\n            <h2>Spinning</h2>\n            <p>Inst: Maria Josefa</p>\n            <p>26/10/2017  3:00 pm</p>\n            <p>Duracion: 60 min</p>\n            <button ion-button clear item-end><ion-icon name="add-circle"></ion-icon></button>\n          </ion-item>\n          <ion-item>\n              <ion-thumbnail item-start>\n                <img src="../assets/imgs/clasesDefensaPersonal.jpeg">\n              </ion-thumbnail>\n              <h2>Defensa Personal</h2>\n              <p>Inst: Pedro Alvarez</p>\n              <p>28/10/2017  3:00 pm</p>\n              <p>Duracion: 60 min</p>\n              <button ion-button clear item-end><ion-icon name="add-circle"></ion-icon></button>\n            </ion-item>\n            <ion-item>\n                <ion-thumbnail item-start>\n                  <img src="../assets/imgs/clasesBoxeo.jpeg">\n                </ion-thumbnail>\n                <h2>Boxeo</h2>\n                <p>Inst: Jesus Rodriguez</p>\n                <p>30/10/2017  3:00 pm</p>\n                <p>Duracion: 60 min</p>\n                <button ion-button clear item-end><ion-icon name="add-circle"></ion-icon></button>\n              </ion-item>\n              <ion-item>\n                  <ion-thumbnail item-start>\n                    <img src="../assets/imgs/claseKickboxing.png">\n                  </ion-thumbnail>\n                  <h2>KickBoxing</h2>\n                  <p>Inst: Marcos Rodriguez</p>\n                  <p>07/11/2017  3:00 pm</p>\n                  <p>Duracion: 60 min</p>\n                  <button ion-button clear item-end><ion-icon name="add-circle"></ion-icon></button>\n                </ion-item>\n      </ion-list>\n</ion-content>\n\n<!-- AUN NO SE SI FUNCIONA ...  ESTOY OFFLINE\n<ion-content padding>\n  <ion-list>\n    <ion-button ion-item *ngFor="let item of items" (click)="goToParticularClase(item)">\n      <ion-thumbnail item-start>\n        <img src="{{item.img}}" alt="">\n        </ion-thumbnail>\n        <h2>{{item.titulo}}</h2>\n        <p>{{item.instructor}}</p>\n        <p>{{item.fecha}}</p>\n        <p>Duracion: {{item.duracion}} min</p>-->\n        <!-- Hay que buscar la forma de eliminar el boton de agregar al presioanrlo\n        <button ion-button clear item-end (click)="reservarClase(item.number) id="botonAgregarReserva-{{item.id}}"><ion-icon name="add-circle"></ion-icon></button>\n    </ion-button>\n  </ion-list>\n</ion-content>\n-->\n'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/clases/clases.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* NavParams */]])
], ClasesPage);

//# sourceMappingURL=clases.js.map

/***/ })

},[195]);
//# sourceMappingURL=main.js.map