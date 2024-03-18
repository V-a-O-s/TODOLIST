import { render, screen, waitFor } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});

test('renders ToDo Liste title', () => {
  render(<App />);
  const linkElement = screen.getByText(/ToDo Liste/i);
  expect(linkElement).toBeInTheDocument();
  expect(linkElement).toBeVisible();
  expect(linkElement).toHaveClass("headline")
});

test('renders \"Absenden\" button', () => {
  render(<App />);
  const linkElement = screen.getByText(/Absenden/i);
  expect(linkElement).toBeInTheDocument();
  expect(linkElement).toBeVisible();
});

test('logo is loading correctly', async () => {
  const { getByAltText } = render(<App />);
  
  await waitFor(() => {
    const logo = getByAltText('logo');
    expect(logo).toBeInTheDocument();
  });
});