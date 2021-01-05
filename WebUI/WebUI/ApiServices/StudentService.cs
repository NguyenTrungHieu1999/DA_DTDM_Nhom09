using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using WebUI.Models;

namespace WebUI.ApiServices
{
    public class StudentService : IStudentService
    {
        private readonly string BaseAddress = "http://student-jdbc-container:8080";

        private readonly HttpClient _client;

        public StudentService(IHttpClientFactory httpClientFactory)
        {
            _client = httpClientFactory.CreateClient();
            _client.BaseAddress = new Uri(BaseAddress);

        }

        public async Task<List<StudentVm>> GetAllAsync()
        {
            string requestUri = $"/students";

            HttpResponseMessage response = await _client.GetAsync(requestUri);

            var body = await response.Content.ReadAsStringAsync();

            var students = JsonConvert.DeserializeObject<List<StudentVm>>(body);

            return students;
        }

        public async Task<bool> InsertAsync(InsertVm studentVm)
        {
            string requestUri = $"/insertstudent";

            var httpContent = new StringContent(JsonConvert.SerializeObject(studentVm), 
                Encoding.Unicode, "application/json");

            var response = await _client.PostAsync(requestUri, httpContent);

            if (response.IsSuccessStatusCode)
            {
                return true;
            }

            return false;
        }

        public async Task<bool> EditAsync(string studentId, InsertVm studentVm)
        {
            string requestUri = $"/students/{studentId}";

            var httpContent = new StringContent(JsonConvert.SerializeObject(studentVm), 
                Encoding.UTF8, "application/json");

            var response = await _client.PutAsync(requestUri, httpContent);

            if (response.IsSuccessStatusCode)
            {
                return true;
            }

            return false;
        }

        public async Task<InsertVm> GetByIdAsync(string studentId)
        {
            string requestUri = $"/students/{studentId}";

            HttpResponseMessage response = await _client.GetAsync(requestUri);

            var body = await response.Content.ReadAsStringAsync();

            var student = JsonConvert.DeserializeObject<InsertVm>(body);

            return student;
        }
    }
}
