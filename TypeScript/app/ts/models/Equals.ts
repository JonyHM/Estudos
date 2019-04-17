import { Igualavel } from './Igualavel';
import { Imprimivel } from './Imprimivel';

export interface Equals<T> extends Imprimivel, Igualavel<T> {

}