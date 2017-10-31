import { NgModule } from '@angular/core';
import { BarraComponent } from './barra/barra';
import { LineaComponent } from './linea/linea';
@NgModule({
	declarations: [BarraComponent,
    LineaComponent],
	imports: [],
	exports: [BarraComponent,
    LineaComponent]
})
export class ComponentsModule {}
