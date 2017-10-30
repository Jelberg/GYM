webpackJsonp([7],{

/***/ 100:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ClasesParticipadasPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(15);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__comentar_clase_comentar_clase__ = __webpack_require__(101);
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
 * Generated class for the ClasesParticipadasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var ClasesParticipadasPage = (function () {
    function ClasesParticipadasPage(navCtrl, navParams) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
    }
    ClasesParticipadasPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ClasesParticipadasPage');
    };
    ClasesParticipadasPage.prototype.goToComentar = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__comentar_clase_comentar_clase__["a" /* ComentarClasePage */]);
    };
    return ClasesParticipadasPage;
}());
ClasesParticipadasPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-clases-participadas',template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/clases-participadas/clases-participadas.html"*/'<!--\n  Generated template for the ClasesParticipadasPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n    <ion-navbar>\n      <button ion-button menuToggle>\n          <ion-icon name="menu"></ion-icon>\n      </button>\n      <ion-title>Clases Participadas</ion-title>\n    </ion-navbar>\n  </ion-header>\n\n\n  <ion-content padding>\n      <ion-list>\n          <ion-item>\n                  <ion-grid>\n                          <ion-row>\n                              <ion-col col-2>\n                                      <ion-avatar item-start>\n                                              <img src="../assets/imgs/clasesYoga.jpg">\n                                          </ion-avatar>\n                              </ion-col>\n                              <ion-col col-6>\n                                      <h2>Yoga</h2>\n                                      <h3>Estela Rodrigues</h3>\n                                      <p>24/10/2017 3:00 pm</p>\n                                      <p>Duracion: 60 min</p>\n                              </ion-col>\n                              <ion-col col-2>\n                                <button ion-button icon-only (click)="goToComentar()">\n                                    <ion-icon name="chatbubbles"></ion-icon>\n                              </button>\n                              </ion-col>\n                              \n                          </ion-row>\n                      </ion-grid>\n          </ion-item>\n          <ion-item>\n                  <ion-grid>\n                          <ion-row>\n                              <ion-col col-2>\n                                      <ion-avatar item-start>\n                                              <img src="../assets/imgs/clasesBoxeo.jpeg">\n                                          </ion-avatar>\n                              </ion-col>\n                              <ion-col col-6>\n                                      <h2>Boxeo</h2>\n                                      <h3>Jesus Rodriguez</h3>\n                                      <p>30/10/2017 3:00 pm</p>\n                                      <p>Duracion: 60 min</p>\n                              </ion-col>\n                              <ion-col col-2>\n                                <button ion-button icon-only (click)="goToComentar()">\n                                        <ion-icon name="chatbubbles"></ion-icon>\n                              </button>\n                              </ion-col>\n                              \n                          </ion-row>\n                      </ion-grid>\n          </ion-item>\n          <ion-item>\n              <ion-grid>\n              </ion-grid>\n          </ion-item>\n        </ion-list>\n  </ion-content>\n'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/clases-participadas/clases-participadas.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* NavParams */]])
], ClasesParticipadasPage);

//# sourceMappingURL=clases-participadas.js.map

/***/ }),

/***/ 101:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ComentarClasePage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(15);
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
 * Generated class for the ComentarClasePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var ComentarClasePage = (function () {
    function ComentarClasePage(navCtrl, navParams, alertCtrl) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.alertCtrl = alertCtrl;
    }
    ComentarClasePage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ComentarClasePage');
    };
    ComentarClasePage.prototype.enviarComentario = function () {
        var alert = this.alertCtrl.create({
            title: 'Comentario',
            subTitle: 'Comentario Enviado!',
            buttons: ['OK']
        });
        alert.present();
        /* HAY QUE ROOTEARLO A LA PAGINA ANTERIOR */
    };
    return ComentarClasePage;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_14" /* ViewChild */])('NAV'),
    __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* Nav */])
], ComentarClasePage.prototype, "nav", void 0);
ComentarClasePage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-comentar-clase',template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/comentar-clase/comentar-clase.html"*/'<!--\n  Generated template for the ComentarClasePage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n\n  <ion-navbar>\n    <ion-title>Comentario</ion-title>\n  </ion-navbar>\n\n</ion-header>\n\n\n<ion-content padding>\n      <div class="tituloContenedor"><p class="titulo">Yoga</p></div> \n      <img src="../../assets/imgs/clasesYoga.jpg" class="imagen">\n      <ion-list>\n            <ion-item>\n              <ion-label floating>Comentario</ion-label>\n              <ion-input type="textarea" ></ion-input>\n            </ion-item>\n          \n            <ion-item>\n              <button ion-button class="botonEnviar" (click)="enviarComentario()">Enviar</button>\n            </ion-item>\n          </ion-list>\n</ion-content>\n'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/comentar-clase/comentar-clase.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* NavParams */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */]])
], ComentarClasePage);

//# sourceMappingURL=comentar-clase.js.map

/***/ }),

/***/ 102:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return InicioPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(15);
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
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* NavParams */]])
], InicioPage);

//# sourceMappingURL=inicio.js.map

/***/ }),

/***/ 103:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ReservasPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(15);
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
    function ReservasPage(navCtrl, navParams, alertCtrl) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.alertCtrl = alertCtrl;
        this.items = [
            { id: 1, titulo: "Yoga", img: "../assets/imgs/clasesYoga.jpg", instructor: "Estela Rodrigues", fecha: "24/10/2017 3:00 pm", duracion: 60 },
            { id: 2, titulo: "Boceo", img: "../assets/imgs/clasesBoxeo.jpg", instructor: "Jesus Rodriguez", fecha: "30/10/2017  3:00 pm", duracion: 60 },
            { id: 3, titulo: "KickBoxing", img: "../assets/imgs/claseKickboxing.jpg", instructor: "Marcos Rodriguez", fecha: "7/11/2017 3:00 pm", duracion: 60 },
        ];
    }
    ReservasPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ReservasPage');
    };
    /* AUN NO SE SI FUNCIONA ...  ESTOY OFFLINE
  
    Deberia eliminar la Reserva
    eliminarReserva(id: number){
      console.log('Reserva Eliminada');
    }
    */
    ReservasPage.prototype.presentAlert = function (id) {
        var alert = this.alertCtrl.create({
            title: 'Reserva',
            subTitle: 'Reserva Eliminada Satisfactoriamente',
            buttons: ['OK']
        });
        alert.present();
    };
    return ReservasPage;
}());
ReservasPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-reservas',template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/reservas/reservas.html"*/'<!--\n  Generated template for the ReservasPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n  <ion-navbar>\n    <button ion-button menuToggle>\n        <ion-icon name="menu"></ion-icon>\n    </button>\n    <ion-title>Reservas</ion-title>\n  </ion-navbar>\n</ion-header>\n\n\n<ion-content padding>\n    <ion-list>\n        <ion-item>\n                <ion-grid>\n                        <ion-row id="claseReservada">\n                            <ion-col col-2>\n                                    <ion-avatar item-start>\n                                            <img src="../assets/imgs/clasesYoga.jpg">\n                                        </ion-avatar>\n                            </ion-col>\n                            <ion-col col-7>\n                                    <h2>Yoga</h2>\n                                    <h3>Estela Rodrigues</h3>\n                                    <p>24/10/2017 3:00 pm</p>\n                                    <p>Duracion: 60 min</p>\n                            </ion-col>\n                            <ion-col>\n                                    <button ion-button icon-only (click)="presentAlert()" class="botonEliminar">\n                                            <ion-icon name="trash"></ion-icon>\n                                        </button>\n                            </ion-col>\n                        </ion-row>\n                    </ion-grid>\n        </ion-item>\n        <ion-item>\n                <ion-grid>\n                        <ion-row id="claseReservada">\n                            <ion-col col-2>\n                                    <ion-avatar item-start>\n                                            <img src="../assets/imgs/clasesBoxeo.jpeg">\n                                        </ion-avatar>\n                            </ion-col>\n                            <ion-col col-7>\n                                    <h2>Boxeo</h2>\n                                    <h3>Jesus Rodriguez</h3>\n                                    <p>30/10/2017 3:00 pm</p>\n                                    <p>Duracion: 60 min</p>\n                            </ion-col>\n                            <ion-col>\n                                    <button ion-button icon-only (click)="presentAlert()" class="botonEliminar">\n                                            <ion-icon name="trash"></ion-icon>\n                                        </button>\n                            </ion-col>\n                        </ion-row>\n                    </ion-grid>\n        </ion-item>\n        <ion-item>\n            <ion-grid>\n                <ion-row id="claseReservada">\n                    <ion-col col-2>\n                            <ion-avatar item-start>\n                                    <img src="../assets/imgs/claseKickboxing.png">\n                                </ion-avatar>\n                    </ion-col>\n                    <ion-col col-7>\n                            <h2>KickBoxing</h2>\n                            <h3>Marcos Rodriguez</h3>\n                            <p>7/11/2017 3:00 pm</p>\n                            <p>Duracion: 60 min</p>\n                    </ion-col>\n                    <ion-col>\n                            <button ion-button icon-only (click)="presentAlert()" class="botonEliminar">\n                                    <ion-icon name="trash"></ion-icon>\n                                </button>\n                    </ion-col>\n                </ion-row>\n            </ion-grid>\n        </ion-item>\n      </ion-list>\n</ion-content>\n\n<!-- AUN NO SE SI FUNCIONA ...  ESTOY OFFLINE\n<ion-content>\n    <ion-list>-->\n        <!--  Hay que buscar la manera de eliminar el item o ocultarlo al eliminar la reserva\n        <ion-item *ngFor="let item of items">\n            <ion-avatar>\n                <img src="{{item.img}}" alt="">\n            </ion-avatar>\n            <h2>{{item.titulo}}</h1>\n            <h3>{{item.instructor}}</h3>\n            <p>{{item.fecha}}</p>\n            <p>Duracion: {{item.duracion}} min</p>\n            <button ion-button icon-only (click)="eliminarReserva(item.id)"><ion-icon name="trash"></ion-icon></button>\n        </ion-item>\n    </ion-list>\n</ion-content>\n-->\n'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/reservas/reservas.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* NavParams */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */]])
], ReservasPage);

//# sourceMappingURL=reservas.js.map

/***/ }),

/***/ 104:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ClasesPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(15);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__clase_particular_clase_particular__ = __webpack_require__(99);
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
    function ClasesPage(navCtrl, navParams, alertCtrl) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.alertCtrl = alertCtrl;
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
    ClasesPage.prototype.presentAlert = function () {
        var alert = this.alertCtrl.create({
            title: 'Clase',
            subTitle: 'Clase Agregada Satisfactoriamente',
            buttons: ['OK']
        });
        alert.present();
    };
    ClasesPage.prototype.goToClaseParticular = function () {
        this.navCtrl.push(__WEBPACK_IMPORTED_MODULE_2__clase_particular_clase_particular__["a" /* ClaseParticularPage */]);
    };
    return ClasesPage;
}());
ClasesPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-clases',template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/clases/clases.html"*/'<!--\n  Generated template for the ClasesPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n  <ion-navbar>\n      <button ion-button menuToggle>\n          <ion-icon name="menu"></ion-icon>\n        </button>\n        <ion-item clase="buscador">\n            <ion-input placeholder="Buscar" type="text"></ion-input>\n          </ion-item>\n  </ion-navbar>\n\n</ion-header>\n<\n<ion-content padding>\n    <ion-list>\n        <ion-item>\n          <button ion-item (click)="goToClaseParticular()">\n          <ion-thumbnail item-start>\n            <img src="../assets/imgs/clasesYoga.jpg">\n          </ion-thumbnail>\n          <h2>Yoga</h2>\n          <p>Inst: Estela Rodrigues</p>\n          <p>24/10/2017  3:00 pm</p>\n          <p>Duracion: 60 min</p>          \n          </button>\n          <button ion-button clear item-end><ion-icon name="add-circle" class="agregarClase" (click)="presentAlert()"></ion-icon></button>\n        </ion-item>\n        <ion-item>\n          <button ion-item (click)="goToClaseParticular()">\n            <ion-thumbnail item-start>\n              <img src="../assets/imgs/claseSpinning.jpg">\n            </ion-thumbnail>\n            <h2>Spinning</h2>\n            <p>Inst: Maria Josefa</p>\n            <p>26/10/2017  3:00 pm</p>\n            <p>Duracion: 60 min</p>\n            </button>\n            <button ion-button clear item-end><ion-icon name="add-circle" class="agregarClase" (click)="presentAlert()"></ion-icon></button>\n          </ion-item>\n          <ion-item>\n            <button ion-item (click)="goToClaseParticular()">\n              <ion-thumbnail item-start>\n                <img src="../assets/imgs/clasesDefensaPersonal.jpeg">\n              </ion-thumbnail>\n              <h2>Defensa Personal</h2>\n              <p>Inst: Pedro Alvarez</p>\n              <p>28/10/2017  3:00 pm</p>\n              <p>Duracion: 60 min</p>\n              </button>\n              <button ion-button clear item-end><ion-icon name="add-circle" class="agregarClase" (click)="presentAlert()"></ion-icon></button>\n            </ion-item>\n            <ion-item>\n              <button ion-item (click)="goToClaseParticular()">\n                <ion-thumbnail item-start>\n                  <img src="../assets/imgs/clasesBoxeo.jpeg">\n                </ion-thumbnail>\n                <h2>Boxeo</h2>\n                <p>Inst: Jesus Rodriguez</p>\n                <p>30/10/2017  3:00 pm</p>\n                <p>Duracion: 60 min</p>\n              </button>\n              <button ion-button clear item-end><ion-icon name="add-circle" class="agregarClase" (click)="presentAlert()"></ion-icon></button>\n              </ion-item>\n              <ion-item>\n                <button ion-item (click)="goToClaseParticular()">\n                <ion-thumbnail item-start>\n                <img src="../assets/imgs/claseKickboxing.png">\n                </ion-thumbnail>\n                <h2>KickBoxing</h2>\n                <p>Inst: Marcos Rodriguez</p>\n                <p>07/11/2017  3:00 pm</p>\n                <p>Duracion: 60 min</p>\n                </button>\n                <button ion-button clear item-end><ion-icon name="add-circle" class="agregarClase" (click)="presentAlert()"></ion-icon></button>\n              </ion-item>\n      </ion-list>\n</ion-content>\n\n<!--\n<ion-content padding>\n  <ion-list>\n    <ion-button ion-item *ngFor="let item of items" (click)="goToParticularClase(item)">\n      <ion-thumbnail item-start>\n        <img src="{{item.img}}" alt="">\n        </ion-thumbnail>\n        <h2>{{item.titulo}}</h2>\n        <p>{{item.instructor}}</p>\n        <p>{{item.fecha}}</p>\n        <p>Duracion: {{item.duracion}} min</p>-->\n        <!-- Hay que buscar la forma de eliminar el boton de agregar al presioanrlo\n        <ion-button ion-item clear item-end (click)="reservarClase(item.number)" id="botonAgregarReserva{{item.id}}"><ion-icon name="add-circle"></ion-icon></ion-button>\n    </ion-button>\n  </ion-list>\n</ion-content>\n-->'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/clases/clases.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* NavParams */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */]])
], ClasesPage);

//# sourceMappingURL=clases.js.map

/***/ }),

/***/ 113:
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
webpackEmptyAsyncContext.id = 113;

/***/ }),

/***/ 154:
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"../pages/clase-particular/clase-particular.module": [
		267,
		6
	],
	"../pages/clases-participadas/clases-participadas.module": [
		268,
		5
	],
	"../pages/clases/clases.module": [
		272,
		4
	],
	"../pages/comentar-clase/comentar-clase.module": [
		269,
		3
	],
	"../pages/inicio/inicio.module": [
		270,
		2
	],
	"../pages/realizar-valoracion/realizar-valoracion.module": [
		273,
		0
	],
	"../pages/reservas/reservas.module": [
		271,
		1
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
webpackAsyncContext.id = 154;
module.exports = webpackAsyncContext;

/***/ }),

/***/ 198:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__ = __webpack_require__(199);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__app_module__ = __webpack_require__(217);


Object(__WEBPACK_IMPORTED_MODULE_0__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_1__app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 217:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ionic_angular__ = __webpack_require__(15);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__app_component__ = __webpack_require__(258);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__ = __webpack_require__(194);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ionic_native_splash_screen__ = __webpack_require__(197);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__pages_inicio_inicio__ = __webpack_require__(102);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__pages_clases_clases__ = __webpack_require__(104);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__pages_reservas_reservas__ = __webpack_require__(103);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__pages_clases_participadas_clases_participadas__ = __webpack_require__(100);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__pages_comentar_clase_comentar_clase__ = __webpack_require__(101);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__pages_clase_particular_clase_particular__ = __webpack_require__(99);
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
            __WEBPACK_IMPORTED_MODULE_8__pages_reservas_reservas__["a" /* ReservasPage */],
            __WEBPACK_IMPORTED_MODULE_9__pages_clases_participadas_clases_participadas__["a" /* ClasesParticipadasPage */],
            __WEBPACK_IMPORTED_MODULE_10__pages_comentar_clase_comentar_clase__["a" /* ComentarClasePage */],
            __WEBPACK_IMPORTED_MODULE_11__pages_clase_particular_clase_particular__["a" /* ClaseParticularPage */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["d" /* IonicModule */].forRoot(__WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* MyApp */], {}, {
                links: [
                    { loadChildren: '../pages/clase-particular/clase-particular.module#ClaseParticularPageModule', name: 'ClaseParticularPage', segment: 'clase-particular', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/clases-participadas/clases-participadas.module#ClasesParticipadasPageModule', name: 'ClasesParticipadasPage', segment: 'clases-participadas', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/comentar-clase/comentar-clase.module#ComentarClasePageModule', name: 'ComentarClasePage', segment: 'comentar-clase', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/inicio/inicio.module#InicioPageModule', name: 'InicioPage', segment: 'inicio', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/reservas/reservas.module#ReservasPageModule', name: 'ReservasPage', segment: 'reservas', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/clases/clases.module#ClasesPageModule', name: 'ClasesPage', segment: 'clases', priority: 'low', defaultHistory: [] },
                    { loadChildren: '../pages/realizar-valoracion/realizar-valoracion.module#RealizarValoracionPageModule', name: 'RealizarValoracionPage', segment: 'realizar-valoracion', priority: 'low', defaultHistory: [] }
                ]
            })
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_2_ionic_angular__["b" /* IonicApp */]],
        entryComponents: [
            __WEBPACK_IMPORTED_MODULE_3__app_component__["a" /* MyApp */],
            __WEBPACK_IMPORTED_MODULE_6__pages_inicio_inicio__["a" /* InicioPage */],
            __WEBPACK_IMPORTED_MODULE_7__pages_clases_clases__["a" /* ClasesPage */],
            __WEBPACK_IMPORTED_MODULE_8__pages_reservas_reservas__["a" /* ReservasPage */],
            __WEBPACK_IMPORTED_MODULE_9__pages_clases_participadas_clases_participadas__["a" /* ClasesParticipadasPage */],
            __WEBPACK_IMPORTED_MODULE_10__pages_comentar_clase_comentar_clase__["a" /* ComentarClasePage */],
            __WEBPACK_IMPORTED_MODULE_11__pages_clase_particular_clase_particular__["a" /* ClaseParticularPage */]
        ],
        providers: [
            __WEBPACK_IMPORTED_MODULE_4__ionic_native_status_bar__["a" /* StatusBar */],
            __WEBPACK_IMPORTED_MODULE_5__ionic_native_splash_screen__["a" /* SplashScreen */],
            { provide: __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ErrorHandler */], useClass: __WEBPACK_IMPORTED_MODULE_2_ionic_angular__["c" /* IonicErrorHandler */] }
        ]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ 258:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MyApp; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(15);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__ = __webpack_require__(194);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__ = __webpack_require__(197);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__pages_inicio_inicio__ = __webpack_require__(102);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__pages_clases_clases__ = __webpack_require__(104);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__pages_reservas_reservas__ = __webpack_require__(103);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__pages_clases_participadas_clases_participadas__ = __webpack_require__(100);
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
    function MyApp(platform, statusBar, splashScreen, menu) {
        menu.enable(true);
        this.rootPage = __WEBPACK_IMPORTED_MODULE_4__pages_inicio_inicio__["a" /* InicioPage */];
        this.pages = [
            { titulo: 'Inicio', component: __WEBPACK_IMPORTED_MODULE_4__pages_inicio_inicio__["a" /* InicioPage */], icon: 'home' },
            { titulo: 'Clases', component: __WEBPACK_IMPORTED_MODULE_5__pages_clases_clases__["a" /* ClasesPage */], icon: 'bicycle' },
            { titulo: 'Reservas', component: __WEBPACK_IMPORTED_MODULE_6__pages_reservas_reservas__["a" /* ReservasPage */], icon: 'calendar' },
            { titulo: 'Clases Participadas', component: __WEBPACK_IMPORTED_MODULE_7__pages_clases_participadas_clases_participadas__["a" /* ClasesParticipadasPage */], icon: 'done-all' },
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
    __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["g" /* Nav */])
], MyApp.prototype, "nav", void 0);
MyApp = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/app/app.html"*/'\n<ion-menu [content]="NAV">\n    <ion-content>\n        <ion-list>\n            <button ion-item *ngFor="let page of pages" (click)="goToPage(page.component)" menuClose="left" munuClose>\n                <ion-icon item-left name="{{page.icon}}"></ion-icon>\n                {{page.titulo}}\n            </button>\n        </ion-list>\n    </ion-content>\n</ion-menu>\n    \n<ion-nav #NAV [root]="rootpage"></ion-nav>'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/app/app.html"*/
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["j" /* Platform */], __WEBPACK_IMPORTED_MODULE_2__ionic_native_status_bar__["a" /* StatusBar */], __WEBPACK_IMPORTED_MODULE_3__ionic_native_splash_screen__["a" /* SplashScreen */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["f" /* MenuController */]])
], MyApp);

//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ 99:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ClaseParticularPage; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ionic_angular__ = __webpack_require__(15);
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
 * Generated class for the ClaseParticularPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
var ClaseParticularPage = (function () {
    function ClaseParticularPage(navCtrl, navParams, alertCtrl) {
        this.navCtrl = navCtrl;
        this.navParams = navParams;
        this.alertCtrl = alertCtrl;
    }
    ClaseParticularPage.prototype.ionViewDidLoad = function () {
        console.log('ionViewDidLoad ClaseParticularPage');
    };
    ClaseParticularPage.prototype.presentAlert = function () {
        var alert = this.alertCtrl.create({
            title: 'Clase',
            subTitle: 'Clase Agregada Satisfactoriamente',
            buttons: ['OK']
        });
        alert.present();
    };
    return ClaseParticularPage;
}());
ClaseParticularPage = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'page-clase-particular',template:/*ion-inline-start:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/clase-particular/clase-particular.html"*/'<!--\n  Generated template for the ClaseParticularPage page.\n\n  See http://ionicframework.com/docs/components/#navigation for more info on\n  Ionic pages and navigation.\n-->\n<ion-header>\n\n  <ion-navbar>\n    <ion-title>Yoga</ion-title>\n  </ion-navbar>\n\n</ion-header>\n\n\n<ion-content padding>\n  <img src="../../assets/imgs/clasesYoga.jpg" alt="" class="imagenClase">\n  <p class="instructor">Inst. Estela Rodriguez</p>\n  <p class="fecha">24/10/2017 3:00 pm</p>\n  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis ornare nunc, vel sagittis risus. Vestibulum et faucibus turpis, dictum blandit erat. In efficitur tortor nec purus tincidunt, ultrices congue ex placerat. Nam augue nisi, egestas sed fermentum fermentum, ullamcorper eget mauris. In facilisis tempor urna. Vestibulum quis dapibus libero. Nulla tristique ex vel magna consequat gravida. Maecenas volutpat volutpat nunc, quis lacinia neque lobortis vitae. Donec luctus ex ac arcu rutrum, at ultricies turpis venenatis. Integer ultricies lobortis ipsum eu cursus. Ut placerat diam ut lacus auctor ullamcorper.</p>\n  <button ion-button item-end class="agregarClase" (click)="presentAlert()">Reservar</button>\n</ion-content>\n'/*ion-inline-end:"/home/elberg/Escritorio/REPOSITORIO/gym/GYM/GYM/src/pages/clase-particular/clase-particular.html"*/,
    }),
    __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1_ionic_angular__["h" /* NavController */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["i" /* NavParams */], __WEBPACK_IMPORTED_MODULE_1_ionic_angular__["a" /* AlertController */]])
], ClaseParticularPage);

//# sourceMappingURL=clase-particular.js.map

/***/ })

},[198]);
//# sourceMappingURL=main.js.map