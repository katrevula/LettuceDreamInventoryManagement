import { Connect, mix } from './node_modules/fronto-connect';
import scopes from './scopes1.js/index.js.js.js';

class UserProfile extends Connect {
  resource = 'contacts';
}

mix(Contact, scopes.readable);
mix(Contact, scopes.writable);

export default Contact;