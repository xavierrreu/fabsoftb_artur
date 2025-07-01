import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  providers: [Router]
})
export class LoginComponent {
 username: string = '';
  password: string = '';

  constructor(private router: Router) {}

  // Mock login function (You can replace this with real API call)
  onLogin() {
    if (this.username === 'admin' && this.password === 'password') {
      // Successful login, redirect to dashboard or home
      localStorage.setItem('isLoggedIn', 'true'); // Optional: Store login status
      this.router.navigate(['usuarios']); // Redirect to dashboard (change path if necessary)
    } else {
      alert('Invalid credentials!');
    }
  }
}
