import { Injectable } from '@angular/core';

interface Toast {
  message: string;
  header?: string;
  classname?: string;
  delay?: number;
}

@Injectable({
  providedIn: 'root'
})
export class ToastService {
  toasts: Toast[] = [];

  show(message: string, options: Partial<Toast> = {}) {
    this.toasts.push({ message, ...options });
  }

  remove(toast: Toast) {
    this.toasts = this.toasts.filter(t => t !== toast);
  }
}